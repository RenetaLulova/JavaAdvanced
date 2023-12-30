# Fishing Competition Problem Description

## Overview
In this fishing competition, you'll navigate a square fishing area to catch fish. Your ship is represented by 'S', fish passages by digits, and whirlpools by 'W'. 'x' represents empty positions.

## Rules
- Your position: 'S'
- Fish passages: Digits indicate the amount of fish.
- Whirlpools: If you fall in, the ship sinks, and you lose your catch.
- Moving out of boundaries: Reappears on the opposite side.

## Goal
Accumulate at least 20 tons of fish for a successful season. Even if the quota is met, the ship keeps moving.

### Input
- Integer n: Size of the square matrix.
- n lines: Rows of the fishing area.
- Move commands: "up", "down", "left", "right".

### Output
- If ship falls in a whirlpool:
  "You fell into a whirlpool! The ship sank and you lost the fish you caught. Last coordinates: [n,n]"
- If quota is reached:
  "Success! You managed to reach the quota!"
- If quota isn't reached:
  "You didn't catch enough fish! Need {lack of fish} more."

### Catch Quantity
- If caught fish > 0: "Amount of fish caught: {quantity} tons."
- If not in whirlpool: Display the matrix.

## Constraints
- Square matrix size: [2-10].
- Matrix: 'S', 'W', digits.
- Position: 'S'.

## Example 1
-Input

4
xxxx
9x5x
34xx
down
down
right
down
collect the nets


-Output
You didn't catch enough fish and didn't reach the quota! You need 8 tons of fish more.
Amount of fish caught: 12 tons.
xxxx
xxxx
xx5x
S4xx

## Example 2
-Input
5
Sxxx9
777x1
W333x
11111
xxxxx
down
down
right
down
collect the nets

-Output
You fell into a whirlpool! The ship sank and you lost the fish you caught. Last coordinates of the ship: [2,0]


