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

select * from notice;


delete from notice where id=31;

rollback;

update notice set
    title='';
    
    
INSERT INTO notice (
    title,
    writer_id,
    content,
    files
) VALUES (
    :v0,
    :v1,
    :v2,
    :v3
);
    
select * from notice;    
    
UPDATE notice
SET
    title='변경테스트22',
    content='갑니다',
    files=''
WHERE
    id = 10;
    
    
DELETE FROM notice
WHERE
        id = :v0
    AND title = :v1
    AND writer_id = :v2
    AND content = :v3
    AND regdate = :v4
    AND hit = :v5
    AND files = :v6
    AND pub = :v7;
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
UPDATE notice
SET
    title = '',
    content = '',
    files = ''
WHERE
    id = :v0;
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
