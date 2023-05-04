# 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
# 
# What is the sum of the digits of the number 2^1000?

# Run using Rstudio; no packages required. 
numstr <- format(2 ^ 1000, scientific=FALSE)

sum = 0
for (c in substring(numstr, 1:nchar(numstr), 1:nchar(numstr))) {
  sum = sum + as.integer(c)
}

sum
