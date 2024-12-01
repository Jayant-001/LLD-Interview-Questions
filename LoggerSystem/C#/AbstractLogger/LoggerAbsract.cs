using LoggerSystem.Data;
using LoggerSystem.Sink;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LoggerSystem.AbstractLogger
{
    public abstract class LoggerAbsract
    {
        public LoggerLevel _loggerLevel;

        public LoggerAbsract? _nextLogger;

        public LoggerAbsract(LoggerLevel loggerLevel)
        {
            _loggerLevel = loggerLevel; 
        }

        public void SetNextLevelLogger( LoggerAbsract nextLevelLogger)
        {
            _nextLogger = nextLevelLogger;
        }

        public void LogMessage(LoggerLevel level, string message, List<ISink> sinks)
        {
            if(level ==_loggerLevel)
            {
                Display(message, sinks);

            }

            if (_nextLogger != null){
                _nextLogger.LogMessage(level, message,sinks);    
            }
        }

        public abstract void Display(string message, List<ISink> sinks);
    }
}
