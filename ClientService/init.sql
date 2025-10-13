CREATE TABLE IF NOT EXISTS public.clients
(
    client_id SERIAL PRIMARY KEY,
    client_name TEXT NOT NULL,
    score SMALLINT NOT NULL
);
