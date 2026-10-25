-- Development-only password activation for rows inserted by sample_data.sql.
-- The WHERE condition only replaces the known seed placeholder hash; it will not
-- overwrite a password subsequently changed by a developer or a pre-existing account.

BEGIN;

UPDATE users
SET password = '$2a$10$Hj08phfbKMKPhUlS/kbdsuWLhuLr3mJp5u6jzF/2mnsK0lGE3wIK6'
WHERE email = 'dev.admin@example.test'
  AND password = '$2a$10$w00Q7ODlBcNp9WuNMzx37uPJO92y.xXtekDzVqJLfnfJu51QZEtGm';

UPDATE users
SET password = '$2a$10$nXCjQxTxcCO8BEN0e2KMGOKhvTyhrQpFrIfJIFkl0YtVtXo9caUBK'
WHERE email = 'dev.user@example.test'
  AND password = '$2a$10$w00Q7ODlBcNp9WuNMzx37uPJO92y.xXtekDzVqJLfnfJu51QZEtGm';

COMMIT;
