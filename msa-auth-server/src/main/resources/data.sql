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
    '{bcrypt}$2a$10$VJ.Rva9gjx7WbDzKJvGPM.jlxpehd2SZKWRF44usy9eebnzFi0vcm',
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

insert into members(email, password, name, comment, user_type, reg_date) values('admin@sample01.com','{bcrypt}$2a$10$dkOIYyJwiX7fvD1rzB1ay.cxGujEyi20iuxN6SIZlC8VkBZWcBOxq', 'james', 'Administrator','1', now());
insert into members(email, password, name, comment, user_type, reg_date) values('tester@sample01.com','{bcrypt}$2a$10$dkOIYyJwiX7fvD1rzB1ay.cxGujEyi20iuxN6SIZlC8VkBZWcBOxq', 'john', 'Tester','2', now());
insert into members(email, password, name, comment, user_type, reg_date) values('developer@sample01.com','{bcrypt}$2a$10$dkOIYyJwiX7fvD1rzB1ay.cxGujEyi20iuxN6SIZlC8VkBZWcBOxq', 'harry', 'developer','3', now());
