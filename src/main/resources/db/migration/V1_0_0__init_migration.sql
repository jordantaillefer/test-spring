create TABLE IF NOT EXISTS pokemon (
    id UUID NOT NULL PRIMARY KEY,
    name varchar(255),
    type varchar(255)
)