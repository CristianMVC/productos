# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table insumos (
  id                        bigint not null,
  nombre                    varchar(255),
  productos_id              bigint,
  constraint pk_insumos primary key (id))
;

create table productos (
  id                        bigint not null,
  name                      varchar(255),
  descripcion               varchar(255),
  constraint pk_productos primary key (id))
;

create sequence insumos_seq;

create sequence productos_seq;

alter table insumos add constraint fk_insumos_productos_1 foreign key (productos_id) references productos (id) on delete restrict on update restrict;
create index ix_insumos_productos_1 on insumos (productos_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists insumos;

drop table if exists productos;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists insumos_seq;

drop sequence if exists productos_seq;

