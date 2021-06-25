def merge_the_tools(string, k):
    #divide string into k length substrings
    x = 0
    y = k 
    subStrs = []
    while (y <= len(string)):
      subStrs.append(string[x:y])
      x += k
      y += k
    
    #remove duplicates in each and print each
    for subStr in subStrs:
        print remove_dups(subStr)
        
def remove_dups(string):
    newstr = []
    for i in range(len(string)):
        if string[i] not in string[:i]:
            newstr.append(string[i])
    newstr1 = ""
    return newstr1.join(newstr)
