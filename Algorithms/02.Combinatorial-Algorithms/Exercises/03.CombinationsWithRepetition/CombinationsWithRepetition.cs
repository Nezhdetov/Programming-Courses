﻿namespace _03.CombinationsWithRepetition
{
    using System;

    public class CombinationsWithRepetition
    {
        private static int[] array;

        public static void Main()
        {
            Console.Write("n = ");
            int n = int.Parse(Console.ReadLine());
            Console.Write("k = ");
            int k = int.Parse(Console.ReadLine());
            array = new int[k];

            GenerateCombinations(n);
        }

        private static void GenerateCombinations(int sizeOfSet, int index = 0, int start = 1)
        {
            if (index >= array.Length)
            {
                Print();
                return;
            }

            for (int i = start; i <= sizeOfSet; i++)
            {
                array[index] = i;
                GenerateCombinations(sizeOfSet, index + 1, i);
            }
        }

        private static void Print()
        {
            Console.WriteLine(string.Join(", ", array));
        }
    }
}