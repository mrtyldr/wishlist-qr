create table if not exists t_music
(
    id         uuid primary key,
    created_at timestamp with time zone,
    updated_at timestamp with time zone,
    title      varchar(255),
    artist     varchar(255),
    rating     double precision
);

alter table public.t_user
    add constraint unique_const unique (email);