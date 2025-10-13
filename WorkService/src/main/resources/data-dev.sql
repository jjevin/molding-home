INSERT INTO public.problems (problem_name, total_frames)
VALUES ('Example', 5);

INSERT INTO public.frames (problem_id, current_frame)
VALUES (1, 0);

INSERT INTO public.particles (frame_id, pos_x, pos_y, pos_z, vel_x, vel_y, vel_z)
VALUES (1, 1, 1, 1, 1, 1, 1);
