CREATE TABLE IF NOT EXISTS public.assignments
(
    assignment_id SERIAL,
    client_id SMALLINT not null,
    frame_id SMALLINT not null,
    assignment_time TIMESTAMP DEFAULT current_timestamp,
    CONSTRAINT assignments_pkey PRIMARY KEY (assignment_id)
)

TABLESPACE pg_default;

ALTER TABLE public.assignments
    OWNER to postgres;
