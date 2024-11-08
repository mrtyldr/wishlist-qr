create table if not exists t_music_request
(
    id         uuid primary key,
    created_at timestamp with time zone,
    updated_at timestamp with time zone,
    session_id uuid,
    artist varchar(255),
    title varchar(255)
);