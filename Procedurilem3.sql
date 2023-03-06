DELIMITER $$
CREATE PROCEDURE verificare_ore1(  s1 int,  s2 int,  s3 int,  oi int , orf int )
BEGIN
	select if(((s1+s2+s3)/60 =orf-oi),1,0) as ifc ;
END $$
DELIMITER ; 