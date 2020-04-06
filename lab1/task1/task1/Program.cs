using System;
using System.IO;
using System.Text;

namespace task1
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Enter text:");
            var input = Console.ReadLine();
            Console.WriteLine("1. Save as it is\n" + 
                              "2. Remove all excess whitespaces\n" +
                              "3. Encode");
            var option = Console.Read() - '0';
            Saver saver;
            switch (option)
            {
                case 2:
                    saver = new Saver(new RemoveWhitespacesSave());
                    break;
                case 3:
                    saver = new Saver(new EncodeSave());
                    break;
                default:
                    saver = new Saver(new RegularSave());
                    break;
            }
            if (saver.Save(input)) Console.WriteLine("Saved successfully");
            else Console.WriteLine("Not saved");
        }
       
    }
    interface SaveMode // Implementation
    {
        const string saveLocation = "C:\\Users\\dmitr\\Desktop\\OOP\\OOP design patterns\\lab1\\task1\\data.txt";
        bool Save(string text);
    }
    class Saver // Abstraction
    {
        SaveMode saveMode;
        public Saver(SaveMode mode)
        {
            this.saveMode = mode;
        }
        public bool Save(string text)
        {
            return this.saveMode.Save(text);
        }
    }
    class RegularSave : SaveMode // Concrete implementation
    {
        public bool Save(string text)
        {
            File.WriteAllText(SaveMode.saveLocation, text);
            return true;
        }
    }
    class RemoveWhitespacesSave : SaveMode // Concrete implementation
    {
        public bool Save(string text)
        {
            StringBuilder sb = new StringBuilder();
            bool removeWhitespace = true;
            for (int i = 0; i < text.Length; i++)
            {
                if (!removeWhitespace && Char.IsWhiteSpace(text[i]))
                {
                    removeWhitespace = true;
                    sb.Append(text[i]);
                }
                else if (!Char.IsWhiteSpace(text[i]))
                {
                    removeWhitespace = false;
                    sb.Append(text[i]);
                }
            }
            File.WriteAllText(SaveMode.saveLocation, sb.ToString());
            return true;
        }
    }
    class EncodeSave : SaveMode // Concrete implementation
    {
        public bool Save(string text)
        {
            var plainTextBytes = System.Text.Encoding.UTF8.GetBytes(text);
            File.WriteAllText(SaveMode.saveLocation, Convert.ToBase64String(plainTextBytes));
            return true;
        }
    }
}