using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LoggerSystem.Sink
{
    public class FileSink : ISink
    {
        public void Log(string message)
        {
            
             Console.WriteLine("[File]:" + message);
            
        }
    }
}
