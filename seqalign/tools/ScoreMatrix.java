package impl;
//******************************************************************************/
//* penalties for gaps                                                         */
//******************************************************************************/
//******************************************************************************/
//* the  similarity with the unknown amino acid X is always 0                  */
//******************************************************************************/
public class ScoreMatrix {
  public double blosum62[][] = {
    {  4.0, -2.0,  0.0, -2.0, -1.0, -2.0,  0.0, -2.0, -1.0, -1.0, -1.0, -1.0, -2.0, -1.0,
     -1.0, -1.0,  1.0,  0.0,  0.0, -3.0, -1.0, -2.0, -1.0 },
    { -2.0,  6.0, -3.0,  6.0,  2.0, -3.0, -1.0, -1.0, -3.0, -1.0, -4.0, -3.0,  1.0, -1.0,
      0.0, -2.0,  0.0, -1.0, -3.0, -4.0, -1.0, -3.0,  2.0 },
    {  0.0, -3.0,  9.0, -3.0, -4.0, -2.0, -3.0, -3.0, -1.0, -3.0, -1.0, -1.0, -3.0, -3.0,
     -3.0, -3.0, -1.0, -1.0, -1.0, -2.0, -1.0, -2.0, -4.0 },
    { -2.0,  6.0, -3.0,  6.0,  2.0, -3.0, -1.0, -1.0, -3.0, -1.0, -4.0, -3.0,  1.0, -1.0,
      0.0, -2.0,  0.0, -1.0, -3.0, -4.0, -1.0, -3.0,  2.0 },
    { -1.0,  2.0, -4.0,  2.0,  5.0, -3.0, -2.0,  0.0, -3.0,  1.0, -3.0, -2.0,  0.0, -1.0,
      2.0,  0.0,  0.0, -1.0, -2.0, -3.0, -1.0, -2.0,  5.0 },
    { -2.0, -3.0, -2.0, -3.0, -3.0,  6.0, -3.0, -1.0,  0.0, -3.0,  0.0,  0.0, -3.0, -4.0,
     -3.0, -3.0, -2.0, -2.0, -1.0,  1.0, -1.0,  3.0, -3.0 },
    {  0.0, -1.0, -3.0, -1.0, -2.0, -3.0,  6.0, -2.0, -4.0, -2.0, -4.0, -3.0,  0.0, -2.0,
     -2.0, -2.0,  0.0, -2.0, -3.0, -2.0, -1.0, -3.0, -2.0 },
    { -2.0, -1.0, -3.0, -1.0,  0.0, -1.0, -2.0,  8.0, -3.0, -1.0, -3.0, -2.0,  1.0, -2.0,
      0.0,  0.0, -1.0, -2.0, -3.0, -2.0, -1.0,  2.0,  0.0 },
    { -1.0, -3.0, -1.0, -3.0, -3.0,  0.0, -4.0, -3.0,  4.0, -3.0,  2.0,  1.0, -3.0, -3.0,
     -3.0, -3.0, -2.0, -1.0,  3.0, -3.0, -1.0, -1.0, -3.0 },
    { -1.0, -1.0, -3.0, -1.0,  1.0, -3.0, -2.0, -1.0, -3.0,  5.0, -2.0, -1.0,  0.0, -1.0,
      1.0,  2.0,  0.0, -1.0, -2.0, -3.0, -1.0, -2.0,  1.0 },
    { -1.0, -4.0, -1.0, -4.0, -3.0,  0.0, -4.0, -3.0,  2.0, -2.0,  4.0,  2.0, -3.0, -3.0,
     -2.0, -2.0, -2.0, -1.0,  1.0, -2.0, -1.0, -1.0, -3.0 },
    { -1.0, -3.0, -1.0, -3.0, -2.0,  0.0, -3.0, -2.0,  1.0, -1.0,  2.0,  5.0, -2.0, -2.0,
      0.0, -1.0, -1.0, -1.0,  1.0, -1.0, -1.0, -1.0, -2.0 },
    { -2.0,  1.0, -3.0,  1.0,  0.0, -3.0,  0.0,  1.0, -3.0,  0.0, -3.0, -2.0,  6.0, -2.0,
      0.0,  0.0,  1.0,  0.0, -3.0, -4.0, -1.0, -2.0,  0.0 },
    { -1.0, -1.0, -3.0, -1.0, -1.0, -4.0, -2.0, -2.0, -3.0, -1.0, -3.0, -2.0, -2.0,  7.0,
     -1.0, -2.0, -1.0, -1.0, -2.0, -4.0, -1.0, -3.0, -1.0 },
    { -1.0,  0.0, -3.0,  0.0,  2.0, -3.0, -2.0,  0.0, -3.0,  1.0, -2.0,  0.0,  0.0, -1.0,
      5.0,  1.0,  0.0, -1.0, -2.0, -2.0, -1.0, -1.0,  2.0 },
    { -1.0, -2.0, -3.0, -2.0,  0.0, -3.0, -2.0,  0.0, -3.0,  2.0, -2.0, -1.0,  0.0, -2.0,
      1.0,  5.0, -1.0, -1.0, -3.0, -3.0, -1.0, -2.0,  0.0 },
    {  1.0,  0.0, -1.0,  0.0,  0.0, -2.0,  0.0, -1.0, -2.0,  0.0, -2.0, -1.0,  1.0, -1.0,
      0.0, -1.0,  4.0,  1.0, -2.0, -3.0, -1.0, -2.0,  0.0 },
    {  0.0, -1.0, -1.0, -1.0, -1.0, -2.0, -2.0, -2.0, -1.0, -1.0, -1.0, -1.0,  0.0, -1.0,
     -1.0, -1.0,  1.0,  5.0,  0.0, -2.0, -1.0, -2.0, -1.0 },
    {  0.0, -3.0, -1.0, -3.0, -2.0, -1.0, -3.0, -3.0,  3.0, -2.0,  1.0,  1.0, -3.0, -2.0,
     -2.0, -3.0, -2.0,  0.0,  4.0, -3.0, -1.0, -1.0, -2.0 },
    { -3.0, -4.0, -2.0, -4.0, -3.0,  1.0, -2.0, -2.0, -3.0, -3.0, -2.0, -1.0, -4.0, -4.0,
     -2.0, -3.0, -3.0, -2.0, -3.0, 11.0, -1.0,  2.0, -3.0 },
    { -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0,
     -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0 },
    { -2.0, -3.0, -2.0, -3.0, -2.0,  3.0, -3.0,  2.0, -1.0, -2.0, -1.0, -1.0, -2.0, -3.0,
     -1.0, -2.0, -2.0, -2.0, -1.0,  2.0, -1.0,  7.0, -2.0 },
    { -1.0,  2.0, -4.0,  2.0,  5.0, -3.0, -2.0,  0.0, -3.0,  1.0, -3.0, -2.0,  0.0, -1.0,
      2.0,  0.0,  0.0, -1.0, -2.0, -3.0, -1.0, -2.0,  5.0 }};

  public char amino_acids[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'K', 'L', 'M', 'N',
                        'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X', 'Y', 'Z', '-'};

  public void encoding(char[] seq) {
    int i;
    for (i = 0; i < seq.length; i++) {
      seq[i] = char2Index(seq[i]);
    }

    return;
  }

  private char char2Index(char c) {
    int result;
    if(c >= 65 && c <= 73) //'A' --> 'I'
    {
      result = c - 65;
    }
    else if (c >= 75 && c <= 78) //'K' --> 'N'
    {
      result = c - 66;
    }
    else if (c >= 80 && c <= 84) //'P' --> 'T'
    {
      result = c - 67;
    }
    else if (c >= 86 && c <= 90) //'V' --> 'Z'
    {
      result = c - 68;
    }
    else if (c >= 97 && c <= 105)
    {
      result = c - 97;
    }
    else if (c >= 107 && c <= 110)
    {
      result = c - 98;
    }
    else if (c >= 112 && c <= 116)
    {
      result = c - 99;
    }
    else if (c >= 118 && c <= 122)
    {
      result = c - 100;
    }
    else
    {
      result = -1;
    }

    return (char)result;
  }
}
