

    class RubikFileReader
    
        Boolean c_fileIsOK

        StreamReader   c_fileReader

      
        

        def RubikFileReader(String p_fileLocation):
            try
            
                c_fileReader = new StreamReader(p_fileLocation)
                c_fileIsOK = true
            
            catch (IOException ex)
            
                Console.WriteLine(ex.Message)
                c_fileIsOK = false
            
        

        def read():
            if !c_fileIsOK)
                return -1
            else
                try
                
                    readChar = c_fileReader.Read()
                    return readChar
                
                catch (IOException ex):
                    Console.WriteLine(ex)
                    return -1
                
        

        def close():
            try
            
                c_fileReader.Close()
            
            catch (IOException ex): Console.WriteLine(ex) 
        
    

