-- Development-only seed data. Run after Flyway has created the schema.
-- Run users_passwords.sql immediately afterward to activate the documented logins.
-- ON CONFLICT clauses preserve existing accounts and links on repeated runs.

BEGIN;

INSERT INTO users (email, password, name, role, created_at)
VALUES
    ('dev.admin@example.test', '$2a$10$w00Q7ODlBcNp9WuNMzx37uPJO92y.xXtekDzVqJLfnfJu51QZEtGm', 'Development Admin', 'ROLE_ADMIN', CURRENT_TIMESTAMP),
    ('dev.user@example.test', '$2a$10$w00Q7ODlBcNp9WuNMzx37uPJO92y.xXtekDzVqJLfnfJu51QZEtGm', 'Development User', 'ROLE_USER', CURRENT_TIMESTAMP)
ON CONFLICT (email) DO NOTHING;

INSERT INTO short_urls (short_key, original_url, is_private, expires_at, created_by, click_count, created_at)
SELECT 'devA1001', 'https://example.com/development/admin-guide', FALSE, NULL, u.id, 0, CURRENT_TIMESTAMP - INTERVAL '2 days'
FROM users u WHERE u.email = 'dev.admin@example.test'
ON CONFLICT (short_key) DO NOTHING;

INSERT INTO short_urls (short_key, original_url, is_private, expires_at, created_by, click_count, created_at)
SELECT 'devA1002', 'https://docs.spring.io/spring-boot/reference/', TRUE, NULL, u.id, 0, CURRENT_TIMESTAMP - INTERVAL '1 day'
FROM users u WHERE u.email = 'dev.admin@example.test'
ON CONFLICT (short_key) DO NOTHING;

INSERT INTO short_urls (short_key, original_url, is_private, expires_at, created_by, click_count, created_at)
SELECT 'devU2001', 'https://spring.io/guides/gs/spring-boot', FALSE, NULL, u.id, 0, CURRENT_TIMESTAMP - INTERVAL '3 hours'
FROM users u WHERE u.email = 'dev.user@example.test'
ON CONFLICT (short_key) DO NOTHING;

INSERT INTO short_urls (short_key, original_url, is_private, expires_at, created_by, click_count, created_at)
SELECT 'devU2002', 'https://www.postgresql.org/docs/current/', TRUE, NULL, u.id, 0, CURRENT_TIMESTAMP - INTERVAL '1 hour'
FROM users u WHERE u.email = 'dev.user@example.test'
ON CONFLICT (short_key) DO NOTHING;

COMMIT;
