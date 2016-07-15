for %%f in (*.jui) do del %%f
for %%f in (*.java) do del %%f
for %%f in (*.ui) do python ui2jui.py %%f
for %%f in (*.jui) do juic.exe -p com.dimediary.view.design -pfUi -a -d ../../java %%f