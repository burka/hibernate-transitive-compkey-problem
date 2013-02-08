create sequence sample_group_seq start 10000;

create table sample_group (
	sample_group_id int primary key,
	payload varchar(200)
);

create table fluid_sample (
	sample_group_id int not null,
	pre_post varchar(20) not null check ( pre_post in ( 'PRE', 'POST') ),
	amount number(20,10) not null,
	primary key ( sample_group_id, pre_post ),
	constraint fk_fluid_sample_group foreign key ( sample_group_id ) references sample_group ( sample_group_id )
);

create table fluid_sample_label (
	sample_group_id int,
	pre_post varchar(20) not null check ( pre_post in ( 'PRE', 'POST') ),
	label varchar(200) not null,
	primary key ( sample_group_id, pre_post, label ),
	constraint fk_fluid_label_fluid foreign key ( sample_group_id, pre_post ) references fluid_sample ( sample_group_id, pre_post )
);
