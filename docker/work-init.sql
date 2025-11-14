CREATE TABLE IF NOT EXISTS public.problems
(
    problem_id SERIAL PRIMARY KEY,
    problem_name TEXT NOT NULL,
    total_frames SMALLINT NOT NULL
);

CREATE TABLE IF NOT EXISTS public.frames
(
    frame_id SERIAL PRIMARY KEY,
    problem_id INTEGER NOT NULL,
    current_frame SMALLINT NOT NULL,
    CONSTRAINT fk_frames_problem FOREIGN KEY (problem_id)
        REFERENCES public.problems (problem_id)
        ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS public.particles
(
    particle_id SERIAL PRIMARY KEY,
    frame_id INTEGER NOT NULL,
    pos_x REAL,
    pos_y REAL,
    pos_z REAL,
    vel_x REAL,
    vel_y REAL,
    vel_z REAL,
    CONSTRAINT fk_particles_frame FOREIGN KEY (frame_id)
        REFERENCES public.frames (frame_id)
        ON DELETE CASCADE
);

