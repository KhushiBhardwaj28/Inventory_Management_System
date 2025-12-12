# Data Migration: MySQL to Supabase Postgres

This runbook uses `pgloader` to migrate existing data from your local MySQL database (`Inventory`) to your Supabase Postgres pooler.

## Prerequisites
- Install pgloader
  - Windows (WSL recommended), macOS (brew), Linux (apt): see https://pgloader.readthedocs.io
- Ensure MySQL is running and accessible at `localhost` with user `root` and password `1234`.
- Ensure Spring Boot is stopped while migrating to avoid concurrent writes.

## Edit credentials if needed
If your MySQL credentials differ, edit `db/pgloader.load` at the `FROM mysql://...` line.

## Run (PowerShell)
```powershell
# If pgloader is in WSL
wsl pgloader "D:/InventoryManagementSystem(Full_Stack)/db/pgloader.load"

# If pgloader is installed natively and available in PATH
pgloader "D:/InventoryManagementSystem(Full_Stack)/db/pgloader.load"
```

`pgloader.load` is configured to:
- Create tables, drop conflicting objects, preserve index names
- Reset sequences, batch-insert for performance
- Cast MySQL date/time types to Postgres `timestamptz`
- Only include these tables: `users`, `products`, `categories`, `suppliers`, `transactions`
- Enforce SSL to Supabase (`sslmode=require`)
- Normalize `transactions.transaction_type` values after load

## Verify
After successful migration:
- Start Spring Boot and confirm logs show Postgres connection
- Validate counts, e.g.
```powershell
# Example checks using psql via WSL
wsl psql "postgresql://postgres.ynthxmwuumqwukothfei:-hK#K!zdP76V#&_@aws-1-ap-south-1.pooler.supabase.com:5432/postgres?sslmode=require" -c "SELECT COUNT(*) FROM products;"
wsl psql "postgresql://postgres.ynthxmwuumqwukothfei:-hK#K!zdP76V#&_@aws-1-ap-south-1.pooler.supabase.com:5432/postgres?sslmode=require" -c "SELECT COUNT(*) FROM categories;"
```

## Notes
- If you have additional tables, add them to the `INCLUDING ONLY` section.
- If your schema names differ (e.g., not `public`), adjust the script accordingly.
- For very large datasets, consider running during off-hours and increasing `workers`/`concurrency`.
