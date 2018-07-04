#Tocheck if a variable is int
op = 2
if (isinstance(op, int)): 
   print("is integer")
 
# To check if string is a -ve number
# WILL NOT GIVE TRUE FOR -ve NUMBERS
op = "32"
if op.isnumeric():
   print("is numeric")
