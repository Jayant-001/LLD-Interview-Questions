using LoggerSystem.AbstractLogger;
using LoggerSystem.Data;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LoggerSystem
{
    public  class LoggerChaining
    {
        public static LoggerAbsract DoChaining()
        {
            LoggerAbsract infoLogger = new LoggerInfo(LoggerLevel.INFO);

            LoggerAbsract errorLogger = new LoggerDebug(LoggerLevel.ERROR);

            LoggerAbsract debugLogger = new LoggerError(LoggerLevel.DEBUG);

            infoLogger.SetNextLevelLogger(errorLogger);

            errorLogger.SetNextLevelLogger(debugLogger);

            return infoLogger;
        }
    }
}
