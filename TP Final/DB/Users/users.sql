#Backoffice tiene permiso para hacer CRUD de usuarios, telefonos y tarifas solamente.

create user 'backoffice'@'%' identified by 'backoffice';

grant select, insert, update, delete  on test.users to  'backoffice'@'%';

grant select, insert, update, delete  on test.phoneLines to  'backoffice'@'%';

grant select, insert, update, delete  on test.rates to  'backoffice'@'%';


#Infraestructura: insert de llamadas solamente

create user 'infraestructura'@'%' identified by 'infraestructura';

grant insert  on test.calls to  'infraestructura'@'%';


#cliente:  select de factura, llamadas 


create user 'cliente'@'%' identified by 'cliente';

grant select on test.bills to  'cliente'@'%';

grant select on test.calls to  'cliente'@'%';

#tambien permitir acceso a la views necesarias

