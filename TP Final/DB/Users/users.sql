#Backoffice tiene permiso para hacer CRUD de usuarios, telefonos y tarifas solamente.

create user 'backoffice'@'%' identified by 'backoffice';

grant select, insert, update, delete  on test.users to  'backoffice'@'%';

grant select, insert, update, delete  on test.phoneLines to  'backoffice'@'%';

grant select, insert, update, delete  on test.rates to  'backoffice'@'%';

grant select on vCallReport to 'backoffice'@'%' ;


#Infraestructura: insert de llamadas solamente

create user 'infraestructura'@'%' identified by 'infraestructura';

grant insert  on test.calls to  'infraestructura'@'%';


#cliente:  select de factura, llamadas, select limitado de users para logearse 


create user 'cliente'@'%' identified by 'cliente';

grant select(username,password) on test.users to 'cliente'@'%';

grant select on test.bills to  'cliente'@'%';

grant select on vCallReport to 'backoffice'@'%' ;

#tambien permitir acceso a la views necesarias

