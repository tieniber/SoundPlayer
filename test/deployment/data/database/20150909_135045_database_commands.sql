ALTER TABLE "testsuite$color"
	ADD "show" BOOLEAN NULL;
UPDATE "testsuite$color"
 SET "show" = false;
INSERT INTO "mendixsystem$attribute" ("id", 
"entity_id", 
"attribute_name", 
"column_name", 
"type", 
"length", 
"default_value", 
"is_auto_number")
 VALUES ('a8c039fb-8f47-4a27-a303-cc788cbf22de', 
'0ab9d4f4-ef25-43c5-9291-8ef27e0062f9', 
'Show', 
'show', 
10, 
200, 
'false', 
false);
UPDATE "mendixsystem$version"
 SET "versionnumber" = '4.0.7', 
"lastsyncdate" = '20150909 13:50:43';
