alter table pokemon
    add type VARCHAR(255);

alter table pokemon
    alter COLUMN type SET NOT NULL;