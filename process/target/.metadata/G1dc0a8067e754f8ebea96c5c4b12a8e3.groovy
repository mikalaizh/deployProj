                                                                                                                                                                                                                                                                                                                 

			//switch to Excel
			inDesktop{
				timeouts(10 * 1000)
				def wordFile = downloadFileOnAgent("https://rpa-grid.s3.amazonaws.com/integration-test/resource/ExcelTemplate.xlsx")

				open("C:\\Program Files (x86)\\Microsoft Office\\root\\Office16\\EXCEL.EXE")

				window("[CLASS:XLMAIN; TITLE:Excel]")

				$(By.cssSelector("[CLASS:NetUISimpleButton; NAME:AIOStartDocument; TEXT:Blank workbook]")).click()

				$(By.cssSelector("[CLASS:NetUIRibbonTab; NAME:FileTabButton]")).click()

				$(By.cssSelector("[CLASS:NetUISimpleButton; NAME:Browse]")).click()

					window("[CLASS:#32770; TITLE:Open]")
					$(By.cssSelector("[CLASS:Edit]")).click()
					log.warn(wordFile.toString())
					sendKeys(wordFile.toString())
					pressEnter()
					sleep(5000)
                window("[CLASS:XLMAIN; REGEXPTITLE:data.+]")

                $(By.cssSelector('[CLASS:DataItem; NAME:H5]')).click()
             	pressCtrlC()

             	actions().dragAndDrop($(By.cssSelector('[CLASS:DataItem; NAME:A1]')),
                    $(By.cssSelector('[CLASS:DataItem; NAME:F4]')))
                    .perform()
               	pressCtrlC()

               	$(By.cssSelector('[CLASS:DataItem; NAME:H5]')).click()
               	pressCtrlV()

             	String textOriginal = $(By.cssSelector('[CLASS:DataItem; NAME:C4]')).getText()
             	String textCopied = $(By.cssSelector('[CLASS:DataItem; NAME:J8]')).getText()

             	sys.defineVariable("textExpected", textExpected);
                sys.defineVariable("textActual", textActual);

			}


			