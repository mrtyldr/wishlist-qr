create table if not exists public.t_user
(
    id          uuid primary key,
    email       varchar(255),
    password    varchar(255),
    first_name  varchar(255),
    last_name   varchar(255),
    nick_name   varchar(255),
    picture_url text,
    about       text,
    created_at  timestamp with time zone,
    updated_at  timestamp with time zone
);

create table if not exists public.t_session
(
    id           uuid primary key,
    created_at   timestamp with time zone,
    updated_at   timestamp with time zone,
    session_name varchar(255),
    user_id      uuid,
    active       boolean
);
