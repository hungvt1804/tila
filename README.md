# tila

```
Program	-> 	begin Statements end EOF
Statements	->	Statement; Statements
				| ϵ
Statement	-> Decl
|Assigment
| Loop
			| print Expr
Decl 	-> 	Type ID ; Decl
			| ϵ
Type		->	int

Assigment	->Id = Expr
Expr 			->Expr - Expr 
			|->Expr * Expr 			 
			|->Expr ^ Expr 
			|->( Expr )
			|-> ID 
		|-> NUMBER
Loop			-> while Expr do begin Statements end

ID = [a..z]|[A..Z] ([a..z]|[A..Z]|[0..9])*
NUMBER = 0|[1..9][0..9]*

Độ ưu tiên (theo thứ tự giảm dần):
-	Expr trong ngoặc 
-	^
-	* 
-	–

Kết hợp:
-	 -, *: kết hợp trái
-	^ kết hợp phải


```

Expr     → literal
               | idf
               | binary
               | grouping ;

literal        → NUMBER;
grouping       → (Expr);
binary         → Expr operator Expr ;
operator       → - | * | ^
idf → ID


Assigment	->Id = Expr




---
Program	-> 	begin Statements end EOF
Statements	->	Statement; Statements
				| ϵ
Statement	-> Decl
|Assigment
| Loop
			| print Expr
Decl 	-> 	Type ID ; Decl
			| ϵ
Type		->	int

x Assigment	->Id = Expr
Expr     → literal
               | idf
               | binary
               | grouping ;

x literal        → NUMBER;
x grouping       → (Expr);
x binary         → Expr operator Expr ;
operator       → - | * | ^
x idf → ID

Loop			-> while Expr do begin Statements end


----

Độ ưu tiên (theo thứ tự giảm dần):
-	Expr trong ngoặc 
-	^
-	* 
-	–

Kết hợp:
-	 -, *: kết hợp trái
-	^ kết hợp phải


5-4-2


Expr -> term
term -> multiply ( ( - ) multiply )*
multiply -> pow ( ( * ) pow )*
pow -> extra ( ( ^ ) extra )+
extra -> primary
primary -> NUMBER | "(" Expr ")"
--- Statement ---
Program	-> 	begin Statements end EOF
Statements	->	Statement; Statements
				| ϵ
Statement	-> Decl
|Assigment
| Loop
			| print Expr
Decl 	-> 	Type ID ; Decl
			| ϵ
Type		->	int

Assigment	->Id = Expr

Loop			-> while Expr do begin Statements end


Program -> begin Statements end EOF
Statements -> (Statement ;)*
Statement -> Decl | Assigment | Loop | PrintStm
PrintStm -> print Expr
Decl -> (Type ID;)*
Type -> int
Assigment -> ID = Expr
Loop -> while Expr do begin Statements end


----
x Program -> begin Statements end EOF
x Statements -> (Statement ;)*
x Statement -> Decl
x Statement -> Assigment
x Statement -> Loop
x Statement -> PrintStm
x PrintStm -> print Expr
x Decl -> Type ID
x Type -> int
x Assigment -> ID = Expr
x Loop -> while Expr do begin Statements end