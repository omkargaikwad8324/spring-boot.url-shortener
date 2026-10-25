# Development sample users

These accounts are for local development only. Do not use them in a deployed environment.

| Email | Role | Password |
| --- | --- | --- |
| `dev.admin@example.test` | `ROLE_ADMIN` | `DevAdmin!2026` |
| `dev.user@example.test` | `ROLE_USER` | `DevUser!2026` |

The passwords are BCrypt hashes generated and checked with the same
`BCryptPasswordEncoder` configured by `WebSecurityConfig`. `sample_data.sql`
initially inserts a BCrypt placeholder so it never stores a plaintext password.
Run `users_passwords.sql` after the seed to activate the logins. Its updates are
limited to each sample email and the exact placeholder hash, preserving hashes
that have since been changed.

## Load into a local database

1. Start PostgreSQL 17 with `docker compose up -d postgres`.
2. Start the application once so Flyway applies V1–V3, then stop it.
3. From the repository root, run both scripts in this order:

   ```powershell
   psql -h localhost -p 5432 -U postgres -d postgres -v ON_ERROR_STOP=1 -f sample_data.sql
   psql -h localhost -p 5432 -U postgres -d postgres -v ON_ERROR_STOP=1 -f users_passwords.sql
   ```

The scripts use unique emails and short keys with `ON CONFLICT DO NOTHING`.
They do not delete rows or overwrite existing user records. The password script
only replaces its own seed placeholder hash, so reruns leave changed passwords
alone.
