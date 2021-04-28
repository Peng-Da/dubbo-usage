--comment
create table comment (
    id BIGSERIAL PRIMARY KEY,
    content varchar,
    publisher_id bigint not null ,--发表人ID
    active boolean default true,
    created_at timestamp not null default now(),
    pid bigint default -1,--父comment id，表示评论和回复的二级关系
    target_id bigint not null ,-- 表示评论对象的id，比如某个视频ID
    target_source varchar -- 表示评论对象的源头，比如教程-练习
)

