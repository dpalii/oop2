using System;
using System.Collections.Generic;

namespace task2
{
    class Program
    {
        static void Main()
        {
            //lib is a root
            Composite library = new Composite("lib");
            //sections
            Composite section1 = new Composite("fantasy");
            library.Add(section1);
            Composite section2 = new Composite("detective");
            library.Add(section2);
            //shelves
            Composite shelve1 = new Composite("shelve1");
            Composite shelve2 = new Composite("shelve2");
            Composite shelve5 = new Composite("shelve5");
            section1.Add(shelve1);
            section1.Add(shelve2);
            section2.Add(shelve5);
            Book bl1 = new Book("Sherlock Holmes");
            Book bl2 = new Book("The Lord of the Rings");
            Book bl3 = new Book("The Lord of the Rings");
            Book bl4 = new Book("The Witcher");
            Book bl5 = new Book("The Game of Thrones");
            Book bl6 = new Book("Sherlock Holmes");
            Book bl7 = new Book("Sherlock Holmes");
            shelve5.Add(bl6);
            shelve5.Add(bl7);
            shelve5.Add(bl1);
            shelve1.Add(bl2);
            shelve1.Add(bl3);
            shelve2.Add(bl4);
            shelve2.Add(bl5);
            // Display all info
            library.GetBookCiphers();
            library.Display(2);
            Console.ReadKey();
        }
    }
    abstract class LibraryComponent 
    {
        public class BookInfo
        {
            public int titles;
            public int total;
            public BookInfo(int total, int titles)
            {
                this.total = total;
                this.titles = titles;
            }
            public override string ToString()
            {
                return "total: " + this.total.ToString() + " titles: " + this.titles.ToString();
            }
        }
        protected string name;
        protected BookInfo info;
        public LibraryComponent(string name)
        {
            this.name = name;
        }
        public abstract void Add(LibraryComponent c);
        public abstract void Remove(LibraryComponent c);
        public abstract List<int> GetBookCiphers();
        public abstract void Display(int depth);

    }
    class Composite : LibraryComponent
    {
        private List<LibraryComponent> _children = new List<LibraryComponent>();
        public Composite(string name) : base(name)
        {
            this.info = new BookInfo(0, 0);
        }
        public override void Add(LibraryComponent component)
        {
            _children.Add(component);
        }
        public override void Remove(LibraryComponent component)
        {
            _children.Remove(component);
        }
        public override void Display(int depth)
        {
            Console.WriteLine(new String('-', depth) + name + " " + this.info.ToString());
            foreach (LibraryComponent component in _children)
                component.Display(depth + 2);
        }
        public override List<int> GetBookCiphers()
        {
            var list = new List<int>();
            var uniques = new List<int>();
            foreach (LibraryComponent component in _children)
            {
                var compList = component.GetBookCiphers();
                list.AddRange(compList);
            }
            this.info.total = list.Count;
            foreach (int code in list)
            {
                if (!uniques.Contains(code)) uniques.Add(code);
            }
            this.info.titles = uniques.Count;
            return list;
        }
    }

    class Book : LibraryComponent
    {
        static private int nextCode;
        public readonly int code;
        public readonly int cipher;
        static Book()
        {
            nextCode = 0;
        }
        public Book(string name) : base(name)
        {
            this.cipher = name.GetHashCode();
            this.code = nextCode;
            nextCode += 1;
            this.info = new BookInfo(0, 0);
        }
        public override void Add(LibraryComponent c)
        {
            Console.WriteLine("Impossible operation");
        }
        public override void Remove(LibraryComponent c)
        {
            Console.WriteLine("Impossible operation");
        }
        public override void Display(int depth)
        {
            Console.WriteLine(new String('-', depth) + name + " code:" + this.code.ToString() + " cipher: " + this.cipher.ToString());
        }
        public override List<int> GetBookCiphers()
        {
            var list = new List<int>();
            list.Add(this.cipher);
            return list;
        }
    }
}
