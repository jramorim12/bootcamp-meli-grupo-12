create table if not exists Link (
  id uuid default random_uuid(),
  url varchar(2048) not null,
  passcode varchar(256) not null,
  redirects int unsigned not null,
  constraint link_pk_constraint primary key (id)
);

create index if not exists link_url_index on Link (url);
