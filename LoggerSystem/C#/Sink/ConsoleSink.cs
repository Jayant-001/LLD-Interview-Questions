using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LoggerSystem.Sink
{
    public class ConsoleSink : ISink
    {
        public void Log(string message)
        {
            Console.WriteLine("[Console]:" + message);
        }
    }
}
