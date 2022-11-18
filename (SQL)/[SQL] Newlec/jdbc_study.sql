INSERT INTO notice (
    --id,
    title,
    writer_id,
    content,
    --regdate,
    --hit,
    files
) VALUES (
    --:v0,
    :v1,
    :v2,
    :v3,
    --:v4,
    --:v5,
    :v6
);

INSERT INTO notice (
    --id,
    title,
    writer_id,
    content,
    --regdate,
    --hit,
    files
) VALUES (
    --:v0,
    'test',
    'java',
    '내용',
    --:v4,
    --:v5,
    ''
);

rollback;

INSERT INTO notice (
    title,
    writer_id,
    content,
    files
) VALUES (
    'test',
    'java',
    '내용',
    ''
);



UPDATE notice
SET
    title ='수정테스트',
    content='갑니다',
    files=''
where id=12;

rollback;


