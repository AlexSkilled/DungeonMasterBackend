CREATE TABLE IF NOT EXISTS game_progress
(
    id SERIAL PRIMARY KEY,
    game_name TEXT,
    payload  TEXT,
    username TEXT,
    user_id SERIAL
);