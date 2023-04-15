main :: IO ()
main = print $ sum $ filter keep firstThousand

allNumbers :: [Int]
allNumbers = 0 : map (+1) allNumbers

firstThousand :: [Int]
firstThousand = take 1000 allNumbers

keep :: Int -> Bool
keep n = n `mod` 3 == 0 || n `mod` 5 == 0