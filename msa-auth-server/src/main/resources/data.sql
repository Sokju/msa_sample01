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
    '{bcrypt}$2a$10$XA5sao22Yb2h7yhhNmv.A.4a5Sj2JhrB3zdMvQ7dFRs9s98dKV032',
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

insert into members(email, password, name, comment, user_type, reg_date) values('admin@sample01.com','{bcrypt}$2a$10$XA5sao22Yb2h7yhhNmv.A.4a5Sj2JhrB3zdMvQ7dFRs9s98dKV032', 'james', 'Administrator','1', now());
insert into members(email, password, name, comment, user_type, reg_date) values('tester@sample01.com','{bcrypt}$2a$10$XA5sao22Yb2h7yhhNmv.A.4a5Sj2JhrB3zdMvQ7dFRs9s98dKV032', 'john', 'Tester','2', now());
insert into members(email, password, name, comment, user_type, reg_date) values('developer@sample01.com','{bcrypt}$2a$10$XA5sao22Yb2h7yhhNmv.A.4a5Sj2JhrB3zdMvQ7dFRs9s98dKV032', 'harry', 'developer','3', now());
