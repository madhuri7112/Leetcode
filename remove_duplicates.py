def give_duplicates(list):
    #create a set data structure for storing result
    result = set()
 
    #traverse through list once and record duplicates
    for x in list:
      x = int(x)
      if int(list[abs(x)-1]) < 0:
         result.add(x)
      else:
         list[abs(x)-1] = int(list[abs(x)-1]) - (2 * int(list[abs(x)-1]))
 
    return result
    
inp = input("Enter list of integers")
#convert string input into an array
list = inp.split()
print(give_duplicates(list))
