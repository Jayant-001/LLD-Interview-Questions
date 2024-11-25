using LoggerSystem.AbstractLogger;
using LoggerSystem.Configuration;
using LoggerSystem.Data;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LoggerSystem
{
    public class Logger
    {
        private static Logger _logger;
        private LoggerAbsract _loggerAbsract ;
        private LoggerConfiguration _loggerConfiguration;
        
        private Logger()
        {
            _loggerAbsract = LoggerChaining.DoChaining();
            _loggerConfiguration = LoggerConfiguration.LoadFromConfiguration();
            if (_logger != null)
                throw new InvalidOperationException("Object already created");
        }

        public static Logger GetLogger()
        {
            if (_logger == null)
            {
                lock (typeof(Logger))
                {
                    if (_logger == null)
                    {
                        _logger = new Logger();
                        
                    }
                }
            }
            return _logger;
        }

        public void Info(string message)
        {
            CreateLog(LoggerLevel.INFO, message);
        }

        public void Error(string message)
        {
            CreateLog(LoggerLevel.ERROR, message);
        }

        public void Debug(string message)
        {
            CreateLog(LoggerLevel.DEBUG, message);
        }

        private void CreateLog(LoggerLevel level, string message)
        {
            
            _loggerAbsract.LogMessage(level, message, _loggerConfiguration.Sinks[level]);
        }
    }
}
