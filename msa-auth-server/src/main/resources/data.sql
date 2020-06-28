DELETE FROM oauth_client_details where client_id = 'testoauth2';

INSERT INTO oauth_client_details
(
    client_id, 
    client_secret,
    resource_ids, 
    scope, 
    authorized_grant_types, 
    web_server_redirect_uri, 
    authorities, 
    access_token_validity, 
    refresh_token_validity, 
    additional_information, 
    autoapprove
)
VALUES
(
    'testoauth2',
    '{bcrypt}$2a$10$PYWfhcBaSAnasnQ5juwkl.HwVoQquNuXunBSMePVyZbafYNwbCS9K',
    null, 
    'read,write', 
    'authorization_code,password,implicit,refresh_token',
    null,
    'ROLE_YOUR_CLIENT',
    36000,
    2592000,
    null,
    null
);

delete from members where email in ('admin@sample01.com','tester@sample01.com','developer@sample01.com');

insert into members(email, password, name, comment, user_type, reg_date) values('admin@sample01.com','{bcrypt}$2a$10$QISl5pkHGjqmtzhMHHk6SeIoBP8Pen5ShVMSnn5fXpPe/QvWctg32', 'james', 'Administrator','1', now());
insert into members(email, password, name, comment, user_type, reg_date) values('tester@sample01.com','{bcrypt}$2a$10$QISl5pkHGjqmtzhMHHk6SeIoBP8Pen5ShVMSnn5fXpPe/QvWctg32', 'john', 'Tester','2', now());
insert into members(email, password, name, comment, user_type, reg_date) values('developer@sample01.com','{bcrypt}$2a$10$QISl5pkHGjqmtzhMHHk6SeIoBP8Pen5ShVMSnn5fXpPe/QvWctg32', 'harry', 'developer','3', now());
