/* Time:2014年04月06日17:03
 * Descrip:一个关于MySql C接口的练习程序，
 * 		   根据http://zetcode.com/db/mysqlc/所写.
 */


#include <my_global.h>
#include <mysql.h>

void finish_with_error(MYSQL *con)
{
	fprintf(stderr, "%s\n", mysql_error(con));
	mysql_close(con);
	exit(1);
}

int main(int argc, char **argv)
{
	/*
	//Display version
	printf("My sql client version: %s\n", mysql_get_client_info());
	*/

	//Initial value
	MYSQL *con = mysql_init(NULL);

	if (con == NULL)
	{
		fprintf(stderr, "%s\n", mysql_error(con));
		exit(1);
	}

	/*
	//Connnect database_1
	if (mysql_real_connect(con, "localhost", "root", "123",
	NULL, 0, NULL, 0) == NULL)
	finish_with_error(con);

	//Create database
	if (mysql_query(con, "CREATE DATABASE testdb"))
	finish_with_error(con);
	*/

	//Connect database_2
	if (mysql_real_connect(con, "localhost", "root", "123", 
				"testdb", 0, NULL, 0) == NULL)
		finish_with_error(con);

	//Drop table
	if (mysql_query(con, "DROP TABLE IF EXISTS Cars"))
		finish_with_error(con);

	//Create table
	if (mysql_query(con, "CREATE TABLE Cars(Id INT PRIMARY KEY AUTO_INCREMENT, Name TEXT, Price INT)")) 
		finish_with_error(con);
	//P.S. AUTO_INCREMENT if for mysql_insert_id();

	//Insert data
	if (mysql_query(con, "INSERT INTO Cars VALUES(1, 'Audi', 52642)"))
		finish_with_error(con);

	if (mysql_query(con, "INSERT INTO Cars VALUES(2,'Mercedes',57127)"))
		finish_with_error(con);

	if (mysql_query(con, "INSERT INTO Cars VALUES(3,'Skoda',9000)"))
		finish_with_error(con);

	if (mysql_query(con, "INSERT INTO Cars VALUES(4,'Volvo',29000)"))
		finish_with_error(con);

	if (mysql_query(con, "INSERT INTO Cars VALUES(5,'Bentley',350000)"))
		finish_with_error(con);

	if (mysql_query(con, "INSERT INTO Cars VALUES(6,'Citroen',21000)"))
		finish_with_error(con);

	if (mysql_query(con, "INSERT INTO Cars VALUES(7,'Hummer',41400)"))
		finish_with_error(con);

	if (mysql_query(con, "INSERT INTO Cars VALUES(8,'Volkswagen',21600)"))
		finish_with_error(con);

	//Display last inserted row id
	int id = mysql_insert_id(con);
	printf("The last inserted row id is: %d\n\n", id);

	//Look for data
	if (mysql_query(con, "SELECT * FROM Cars"))
		finish_with_error(con);

	//Store the data
	MYSQL_RES *result = mysql_store_result(con);

	if (result == NULL)
		finish_with_error(con);

	//Display the column headers and data.
	int num_fields = mysql_num_fields(result);
	MYSQL_ROW row;
	MYSQL_FIELD *field;

	while (field = mysql_fetch_field(result))
	{
		printf("%s  ", field->name);
	}
	printf("\n");

	while (row = mysql_fetch_row(result))
	{
		for (int i = 0; i < num_fields; i++)
		{
			printf("%s  ", row[i] ? row[i] : "NULL");
		}
		printf("\n");
	}

	mysql_free_result(result);
	mysql_close(con);

	exit(0);
}
