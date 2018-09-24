package begin.kot.com.droidkot.domain.commands

public interface Command<T>{
    fun execute():T
}