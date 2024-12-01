﻿using LoggerSystem.Data;
using LoggerSystem.Sink;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LoggerSystem.AbstractLogger
{
    public class LoggerDebug : LoggerAbsract
    {
        public LoggerDebug(LoggerLevel loggerLevel) : base(loggerLevel)
        {
        }

        public override void Display(string message,List<ISink> sinks)
        {
            string timestamp = DateTime.Now.ToString("yyyy-MM-dd HH:mm:ss");
            string enrichedMessage = $"{timestamp} [{_loggerLevel}]): {message}";
            foreach (var sink in sinks)
            {
                sink.Log(enrichedMessage);
            }

        }
    }
}