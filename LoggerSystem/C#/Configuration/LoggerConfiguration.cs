using LoggerSystem.Data;
using LoggerSystem.Sink;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LoggerSystem.Configuration
{
    public class LoggerConfiguration
    {
        public Dictionary<LoggerLevel,List<ISink>> Sinks { get; set; }

        public LoggerConfiguration()
        {
            Sinks = new Dictionary<LoggerLevel, List<ISink>>();
        }

        public static LoggerConfiguration LoadFromConfiguration()
        {
            var config = new LoggerConfiguration();

            config.AddSink(LoggerLevel.INFO, new ConsoleSink());
            config.AddSink(LoggerLevel.ERROR, new FileSink());
            config.AddSink(LoggerLevel.INFO, new FileSink());
            config.AddSink(LoggerLevel.DEBUG, new FileSink());

            return config;
        }

        public void AddSink(LoggerLevel level, ISink sink)
        {
            if (!Sinks.ContainsKey(level))
            {
                Sinks[level] = new List<ISink>();
            }
            Sinks[level].Add(sink);
        }
    }
}
