(1 to 1000)
  .filter { zahl =>
    zahl % 3 == 0 && zahl % 5 == 0
  }
  .sum