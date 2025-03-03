# MazeCrawler

A maze navigator that uses recursive algorithms and backtracking to navigate a maze of x's. Path leading to exit will be marked by 'P's, and any path that leads to a dead end will be marked by 'V's. Starting and ending points will be marked by an 'S' and 'F', respectively.

Specifications of rows, columns, starting point and ending point must be provided.

Example:
20 7 (Columns, Rows)
18 0 (Ending Coordinate)
12 6 (Starting Coordinate)
xxxxxxxxxxxxxxxxxx x
x     x       xxxx x
x xxxxx xxxxx   xx x
x xxxxx xxxxxxx xx x
x            xx xx x
x xxxxxxxxxx xx    x
xxxxxxxxxxxx xxxxxxx

Output:

xxxxxxxxxxxxxxxxxxPx
xVVVVVxPPPPPPPxxxxPx
xVxxxxxPxxxxxPPPxxPx
xVxxxxxPxxxxxxxPxxPx
xVVVVVVPPPPPPxxPxxPx
xVxxxxxxxxxxPxxPPPPx
xxxxxxxxxxxxSxxxxxxx
