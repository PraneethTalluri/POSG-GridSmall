#include <iostream>
#include <fstream>
#include <cstring>
#include <cstdlib>
using namespace std;

int main()
{
  double x=0,discount;
  int count=0,nodes,states,actions,observations,a=0,b=0,c=0,d=0,e=0;
  string STRING,str,str1;
  
  double inital_belief[30];
  memset(inital_belief, 0, sizeof(inital_belief));
	
	double trans[30][10][10][30];
  memset(trans, 0, sizeof(trans[0][0][0][0])*30*10*10*30);
  
  double obs[5][5][30][10][10];
  memset(obs, 0, sizeof(obs[0][0][0][0][0])*5*5*30*10*10);
  
  double reward[30][10][10];
  memset(reward, 0, sizeof(reward[0][0][0])*30*10*10);
  
	ifstream infile;
	infile.open ("GridSmall.posg");
	
	if (!infile)
	{
    cerr <<endl<< "File failed to open"<<endl<<endl;
    return 1;
  }
	
        while(!infile.eof()) // To get you all the lines.
        {
          if(count<6)
          {
			      getline(infile,STRING); // Saves the line in STRING.
			      char * cstr = new char [STRING.length()+1];
						std::strcpy (cstr, STRING.c_str());					// str now contains a c-string copy of string
						if (strncmp (cstr,"param",5) == 0)
						{
							str = STRING.substr(STRING.find("=") + 1, STRING.length()+1-STRING.find("="));
							a = atoi (str.c_str());
							//cout<<a<<endl;
							nodes=a;						
						}
						count++	;					
						delete[] cstr;
						
						getline(infile,STRING); // Saves the line in STRING.
			      char * cstr1 = new char [STRING.length()+1];
						std::strcpy (cstr1, STRING.c_str());					// str now contains a c-string copy of string
						if (strncmp (cstr1,"param",5) == 0)
						{
							str = STRING.substr(STRING.find("=") + 1, STRING.length()+1-STRING.find("="));
							a = atoi (str.c_str());
							//cout<<a<<endl;
							states=a;						
						}
						count++	;					
						delete[] cstr1;
						
						getline(infile,STRING); // Saves the line in STRING.
			      char * cstr2 = new char [STRING.length()+1];
						std::strcpy (cstr2, STRING.c_str());					// str now contains a c-string copy of string
						if (strncmp (cstr2,"param",5) == 0)
						{
							str = STRING.substr(STRING.find("=") + 1, STRING.length()+1-STRING.find("="));
							a = atoi (str.c_str());
							//cout<<a<<endl;
							actions=a;						
						}
						count++		;				
						delete[] cstr2;
						
						getline(infile,STRING); // Saves the line in STRING.
			      char * cstr3 = new char [STRING.length()+1];
						std::strcpy (cstr3, STRING.c_str());					// str now contains a c-string copy of string
						if (strncmp (cstr3,"param",5) == 0)
						{
							str = STRING.substr(STRING.find("=") + 1, STRING.length()+1-STRING.find("="));
							a = atoi (str.c_str());
							//cout<<a<<endl;
							observations=a;						
						}
						count++;						
						delete[] cstr3;
											
						getline(infile,STRING); // Saves the line in STRING.
			      char * cstr4 = new char [STRING.length()+1];
						std::strcpy (cstr4, STRING.c_str());					// str now contains a c-string copy of string
						if (strncmp (cstr4,"param",5) == 0)
						{
							str = STRING.substr(STRING.find("=") + 1, STRING.length()+1-STRING.find("="));
							x = atof (str.c_str());
							//cout<<x<<endl;
							discount=x;						
						}
						count++	;					
						delete[] cstr4;
						
						getline(infile,STRING); // Saves the line in STRING.
			      char * cstr5 = new char [STRING.length()+1];
						std::strcpy (cstr5, STRING.c_str());					// str now contains a c-string copy of string
						if (strncmp (cstr5,"param",5) == 0)
						{
							str = STRING.substr(STRING.find("=") + 1, STRING.length()+1-STRING.find("="));
							a = atoi (str.c_str());
							//cout<<a<<endl;
							str = str.substr(2);			
							x = atof (str.c_str());
							//cout<<x<<endl;
							inital_belief[a]=x;
							
						}
						count++	;					
						delete[] cstr5;					
		     }
		     else if (count==6)
		     {
		        getline(infile,STRING); // Saves the line in STRING.
			      char * cstr6 = new char [STRING.length()+1];
						std::strcpy (cstr6, STRING.c_str());					// str now contains a c-string copy of string
						if (strncmp (cstr6,";",1) == 0)
						{
							count++	;	
						}
						else
						{
						  str = STRING;
							a = atoi (str.c_str());
							//cout<<a<<endl;
							str = str.substr(2);			
							x = atof (str.c_str());
							//cout<<x<<endl;
							inital_belief[a]=x;
						}										
						delete[] cstr6;
		     }
		     else if (count==7)
		     {
		        getline(infile,STRING); // Saves the line in STRING.
			      char * cstr7 = new char [STRING.length()+1];
						std::strcpy (cstr7, STRING.c_str());					// str now contains a c-string copy of string
						if (strncmp (cstr7,";",1) == 0)
						{
							count++	;	
						}
						else
						{
						 str = STRING.substr(STRING.find("[") + 1, (STRING.find("]") - STRING.find("[")) - 1);
						  str1 = STRING.substr(STRING.find("]") + 1);
							a = atoi(str.substr(0, str.find(", ")).c_str());
							//cout<<a<<endl;
							str = str.substr(str.find(", ") + 2);
							b = atoi(str.substr(0, str.find(", ")).c_str());
							//cout<<b<<endl;
							str = str.substr(str.find(", ") + 2);
							c = atoi(str.substr(0, str.find(", ")).c_str());
							//cout<<c<<endl;
							str = str.substr(str.find(", ") + 2);
							d = atoi(str.c_str());
							//cout<<d<<endl;
						  x = atof (str1.c_str());
							//cout<<x<<endl;
							trans[a][b][c][d]=x;
						}										
						delete[] cstr7;
		     }
		     else if (count==8)
		     {
		        getline(infile,STRING); // Saves the line in STRING.
			      char * cstr8 = new char [STRING.length()+1];
						std::strcpy (cstr8, STRING.c_str());					// str now contains a c-string copy of string
						if (strncmp (cstr8,";",1) == 0)
						{
							count++	;	
						}
						else
						{
						  str = STRING.substr(STRING.find("[") + 1, (STRING.find("]") - STRING.find("[")) - 1);
						  str1 = STRING.substr(STRING.find("]") + 1);
							a = atoi(str.substr(0, str.find(", ")).c_str());
							//cout<<a<<endl;
							str = str.substr(str.find(", ") + 2);
							b = atoi(str.substr(0, str.find(", ")).c_str());
							//cout<<b<<endl;
							str = str.substr(str.find(", ") + 2);
							c = atoi(str.substr(0, str.find(", ")).c_str());
							//cout<<c<<endl;
							str = str.substr(str.find(", ") + 2);
							d = atoi(str.substr(0, str.find(", ")).c_str());
							//cout<<c<<endl;
							str = str.substr(str.find(", ") + 2);
							e = atoi(str.c_str());
							//cout<<d<<endl;
						  x = atof (str1.c_str());
							//cout<<x<<endl;
							obs[a][b][c][d][e]=x;
						}										
						delete[] cstr8;
		     }
		     else if (count==9)
		     {
		        getline(infile,STRING); // Saves the line in STRING.
			      char * cstr9 = new char [STRING.length()+1];
						std::strcpy (cstr9, STRING.c_str());					// str now contains a c-string copy of string
						if (strncmp (cstr9,";",1) == 0)
						{
							count++	;	
							getline(infile,STRING); 
							getline(infile,STRING);
							cout<<endl<<"Succussfully parsed the file and stored the values"<<endl<<endl;
						}
						else
						{
						 str = STRING.substr(STRING.find("[") + 1, (STRING.find("]") - STRING.find("[")) - 1);
						  str1 = STRING.substr(STRING.find("]") + 1);
							a = atoi(str.substr(0, str.find(", ")).c_str());
							//cout<<a<<endl;
							str = str.substr(str.find(", ") + 2);
							b = atoi(str.substr(0, str.find(", ")).c_str());
							//cout<<b<<endl;
							str = str.substr(str.find(", ") + 2);
							c = atoi(str.c_str());
							//cout<<d<<endl;
						  x = atof (str1.c_str());
							//cout<<x<<endl;
							reward[a][b][c]=x;
						}										
						delete[] cstr9;	
						//cout<<"count "<<count<<endl;					
		     }
        }
	infile.close();
		
	return 0;
}
