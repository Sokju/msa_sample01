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
    '$2a$10$8h4RMzia4yhN5Kr/gtPoF.KhCYXr49hItBVnFD66YwuKBqq0m8vcG',
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

insert into members(email, password, name, comment, user_type, reg_date) values('admin@sample01.com','$2a$10$UQVTvPrDntukWob4IMJUTem/PwHI1mvWZaoIDgxaRGFg7Lxpnvexq', 'james', 'Administrator','1', now());
insert into members(email, password, name, comment, user_type, reg_date) values('tester@sample01.com','$2a$10$UQVTvPrDntukWob4IMJUTem/PwHI1mvWZaoIDgxaRGFg7Lxpnvexq', 'john', 'Tester','2', now());
insert into members(email, password, name, comment, user_type, reg_date) values('developer@sample01.com','$2a$10$UQVTvPrDntukWob4IMJUTem/PwHI1mvWZaoIDgxaRGFg7Lxpnvexq', 'harry', 'developer','3', now());
